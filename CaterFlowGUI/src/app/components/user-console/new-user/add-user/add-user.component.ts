import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { MatIconModule } from '@angular/material/icon';
import { UserRole } from 'src/app/components/shared/enums/user-role.enum';
import { CommonModule } from '@angular/common';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { UserRegistration } from 'src/app/model/user-registration';
import { UserRegistrationService } from 'src/app/services/user-console/register/user-registration.service';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.css'],
  standalone: true,
  imports: [
    FormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatSelectModule,
    MatIconModule,
    CommonModule,
    MatCheckboxModule,
    MatSnackBar,
  ],
})
export class AddUserComponent {
  hide = true;
  roleNames: string[] = Object.values(UserRole);

  userRegistrationForm: UserRegistration = new UserRegistration(
    ' ',
    '',
    '',
    ',',
    '',
    []
  );

  constructor(private userRegisterService: UserRegistrationService, private snackBar: MatSnackBar) {}

  onSubmit(): void {
    this.userRegisterService
      .registerUser(this.userRegistrationForm)
      .subscribe((response) => {
        this.snackBar.open('Registration Successful!', 'Close', {duration: 3000})
        error: this.snackBar.open('Registration failed, submit again.', 'Close', {duration: 3000})
      });
  }
}
