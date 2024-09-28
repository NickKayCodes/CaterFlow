import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { provideHttpClient, withInterceptorsFromDi } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatSnackBarModule } from '@angular/material/snack-bar';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { HomeComponent } from './components/home/home/home.component';
import { UserConsoleComponent } from './components/user-console/user-console/user-console.component';

@NgModule({ declarations: [
        AppComponent,
        LoginComponent,
        NavbarComponent,
        HomeComponent,
        UserConsoleComponent,
    ],
    bootstrap: [AppComponent], imports: [BrowserModule,
        AppRoutingModule,
        FormsModule,
        BrowserAnimationsModule,
        RouterModule,
        MatFormFieldModule,
        MatIconModule,
        MatSnackBarModule], providers: [provideHttpClient(withInterceptorsFromDi())] })
export class AppModule {}
