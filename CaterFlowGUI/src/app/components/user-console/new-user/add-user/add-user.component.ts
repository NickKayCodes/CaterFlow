import { Component } from '@angular/core';
import { Validators } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { MatIconModule } from '@angular/material/icon';
import { UserRole } from 'src/app/components/shared/enums/user-role.enum';
import { CommonModule } from '@angular/common';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { UserRegistrationService } from 'src/app/services/user-console/register/user-registration.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ReactiveFormsModule, FormGroup, FormBuilder } from '@angular/forms';


@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.css'],
  standalone: true,
  imports: [
    ReactiveFormsModule,
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

  userRegistrationForm!: FormGroup;

  constructor(
    private userRegisterService: UserRegistrationService,
    private snackBar: MatSnackBar,
    private formBuilder: FormBuilder
  ) {}

  ngOnInit(): void {
    //Called after the constructor, initializing input properties, and the first call to ngOnChanges.
    //Add 'implements OnInit' to the class.
    this.userRegistrationForm = this.formBuilder.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      username: ['', Validators.required],
      password: ['', Validators.required],
      email: ['', Validators.required],
      roles: [[]]
    });
  }

  onSubmit(): void {
    this.userRegisterService
      .registerUser(this.userRegistrationForm.value)
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

      this.userRegistrationForm.reset();
      this.userRegistrationForm.markAsPristine();
      this.userRegistrationForm.markAsUntouched();
  }

}


