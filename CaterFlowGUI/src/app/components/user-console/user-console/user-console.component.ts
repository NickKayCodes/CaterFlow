import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserRegistration } from 'src/app/model/user-registration';
import { UserProfileService } from 'src/app/services/user-console/user-profile/user-profile.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-user-console',
  templateUrl: './user-console.component.html',
  styleUrls: ['./user-console.component.css'],
})
export class UserConsoleComponent implements OnInit, OnDestroy {
  public userData: UserRegistration[] = [];
  private userSubscription!: Subscription;
  
  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private userService: UserProfileService
  ) {}

  ngOnInit(): void {
    this.userSubscription = this.userService
      .getAllUsers()
      .subscribe((userData) => {
        this.userData = userData;
      });
  }

  ngOnDestroy(): void {
    //Called once, before the instance is destroyed.
    //Add 'implements OnDestroy' to the class.
    
    this.userSubscription.unsubscribe()
  }
}
