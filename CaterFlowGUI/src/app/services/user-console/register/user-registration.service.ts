import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UserRegistration } from 'src/app/model/user-registration';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class UserRegistrationService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) {}

  /**
   * this function registers a new user with the spring boot server via rest api
   *
   *
   */
  public registerUser(newUser: UserRegistration): Observable<any> {

    return this.http.post<any>(`${this.apiServerUrl}/user/register`, newUser);
  }
}
