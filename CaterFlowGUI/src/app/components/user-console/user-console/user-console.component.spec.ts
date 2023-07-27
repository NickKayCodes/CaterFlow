import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserConsoleComponent } from './user-console.component';

describe('UserConsoleComponent', () => {
  let component: UserConsoleComponent;
  let fixture: ComponentFixture<UserConsoleComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UserConsoleComponent]
    });
    fixture = TestBed.createComponent(UserConsoleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
