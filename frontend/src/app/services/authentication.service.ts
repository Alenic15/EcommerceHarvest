import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../common/user';
import { Userdto } from '../common/userdto';
import { Jwtclient } from '../common/jwtclient';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  private apiUrl : string = 'http://localhost:8085/api/v1/security';

  private isLoggedInStatus: boolean = false; // Estado de inicio de sesión

  constructor(private httpClient: HttpClient) { }

  register(user : User):Observable<User>{
    return this.httpClient.post<User>(this.apiUrl+"/register", user);
  }

  login(userDto:Userdto):Observable<Jwtclient>{
    return this.httpClient.post<Jwtclient>(this.apiUrl+"/login", userDto);

  }

  // Método para iniciar sesión

  setLogin(jwtClient: Jwtclient) {

    this.isLoggedInStatus = true;

    sessionStorage.setItem('token', jwtClient.token); // Almacenar solo el token

  }


  // Método para cerrar sesión

  logout() {

    this.isLoggedInStatus = false;

    sessionStorage.removeItem('token'); // Eliminar el token de sessionStorage

  }


  // Método para verificar si el usuario está autenticado

  isLoggedIn(): boolean {

    return this.isLoggedInStatus || !!sessionStorage.getItem('token');

  }

}
