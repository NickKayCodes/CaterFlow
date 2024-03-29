import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
@Injectable({
  providedIn: 'root',
})
export class UserProfileService {
  private apiServerUrl = environment.apiBaseUrl;



  constructor(private http: HttpClient) {}

  getAllUsers(): Observable<any> {
    return this.http.get<any[]>(`${this.apiServerUrl}/user/getAllUsers`);
  }
}
