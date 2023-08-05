import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { MatIconModule } from '@angular/material/icon';
import { UserRole } from 'src/app/components/shared/enums/user-role.enum';
import { CommonModule } from '@angular/common';
import { MatCheckboxChange, MatCheckboxModule } from '@angular/material/checkbox';
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
  ],
})



export class AddUserComponent {
  hide = true;
  roleNames: UserRole[] = Object.values(UserRole);
  selectedRoles: UserRole[] = [];

  userRegistrationForm: UserRegistration = new UserRegistration(
    '',
    '',
    '',
    '',
    '',
    []
  );

  constructor(
    private userRegisterService: UserRegistrationService,
    private snackBar: MatSnackBar
  ) {}

  onRoleSelectionChange(event: MatCheckboxChange, role: UserRole): void {
    if (event.checked) {
      this.selectedRoles.push(role);
    } else {
      const index = this.selectedRoles.indexOf(role);
      if (index !== -1) {
        this.selectedRoles.splice(index, 1);
      }
    }
  }

  onSubmit(): void {
    //server stores roles in a set, so make sure to make the changes to handle the array being sent in the JSON
    this.userRegistrationForm.roles = this.selectedRoles;

    console.log('form data: ', this.userRegistrationForm);

    this.userRegisterService
      .registerUser(this.userRegistrationForm)
      .subscribe((response) => {
        this.snackBar.open('Registration Successful!', 'Close', {
          duration: 3000,
        });
        error: this.snackBar.open(
          'Registration failed, submit again.',
          'Close',
          { duration: 3000 }
        );
      });
  }



}


