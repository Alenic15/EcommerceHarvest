import { Component, OnInit } from '@angular/core';
import { OrderState } from 'src/app/common/order-state';
import { OrderService } from 'src/app/services/order.service';
import { SessionStorageService } from 'src/app/services/session-storage.service';
import { Router } from '@angular/router'; // Importa Router

@Component({
  selector: 'app-payment-success',
  templateUrl: './payment-success.component.html',
  styleUrls: ['./payment-success.component.css']
})
export class PaymentSuccessComponent implements OnInit {
  successMessage: string = ''; // Mensaje de éxito

  constructor(
    private orderService: OrderService,
    private sessionStorage: SessionStorageService,
    private router: Router // Inyecta Router
  ) { }

  ngOnInit(): void {
    console.log(this.sessionStorage.getItem('order'));
    let order = this.sessionStorage.getItem('order');

    let formData = new FormData();
    formData.append('id', order.id);
    formData.append('state', OrderState.CONFIRMED.toString());

    this.orderService.updateOrder(formData).subscribe(
      data => { 
        console.log(data);
        console.log('Token actual: ' + this.sessionStorage.getItem('token'));

        // Mostrar mensaje de éxito
        this.successMessage = 'Pago exitoso. Redirigiendo...';

        // Redirigir al home después de un retraso
        setTimeout(() => {
          this.router.navigate(['/']); // Redirige a la página de inicio
        }, 5000); 
      },
      error => {
        console.error('Error al actualizar el pedido', error);
      }
    );
  }
}