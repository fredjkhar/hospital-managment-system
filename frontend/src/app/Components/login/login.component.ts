import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  userId: string = '';
  password: string = '';

  constructor(private router: Router) {}

  login(): void {
    console.log(`login clicked with Username: ${this.userId}, Password: ${this.password}`);
    if (this.userId && this.password) {
      this.router.navigate(['/staff']);
    } else {
      // Handle unsuccessful registration
      console.log('login failed. Please check your credentials.');
    }
  }

  register(): void {
    this.router.navigate(['register'])
  }
}
