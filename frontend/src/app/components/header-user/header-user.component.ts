import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from 'src/app/services/authentication.service';

@Component({
  selector: 'app-header-user',
  templateUrl: './header-user.component.html',
  styleUrls: ['./header-user.component.css']
})

export class HeaderUserComponent {
  constructor(private authService: AuthenticationService, private router: Router) { }


  isLoggedIn() {

    return this.authService.isLoggedIn();

  }


  logout() {

    this.authService.logout(); // Llama al método de logout del servicio

    this.router.navigate(['/']); // Redirige a la página de inicio

  }
}

