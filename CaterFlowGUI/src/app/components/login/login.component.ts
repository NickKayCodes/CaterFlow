import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { UserLogin } from 'src/app/model/user-login';
import { LoginService } from 'src/app/services/login-service/login.service';
import { LoginError, LoginResponse } from './login-interface/login.interface';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  user: UserLogin = new UserLogin('', '');
  message = '';

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    //add login service
    private loginService: LoginService
  ) {}

  ngOnInit(): void {}

  /**
   * doLogin function, needs login service to interact with backend
   */
  doLogin() {
    this.loginSubmit(this.user);
  }

  //login submit
  loginSubmit(user: UserLogin) {
    this.loginService.loginUser(user).subscribe(
      (loginData: LoginResponse) => {
        console.log(this.user); //checking data will remove afterwards
        this.message = loginData.message;
        sessionStorage.setItem('token', user.username);
        sessionStorage.setItem('user', JSON.stringify(user));
        this.router.navigate(['/home']);
      },
      (error: LoginError) => {
        console.log(this.user);
        this.message = 'Please check your credentials';
        console.log('error');
      }
    );
  }
}
