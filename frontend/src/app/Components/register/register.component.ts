import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})

export class RegisterComponent {
  username: string = '';
  password: string = '';
  email: string = '';
  usernumb: string = '';

  constructor(private router: Router) {}

  register(): void {
    console.log(`Register clicked with Username: ${this.username}, Password: ${this.password}`);
    if (this.username && this.password && this.email && this.usernumb) {
      this.router.navigate(['/staff']);
    } else {
      // Handle unsuccessful registration
      console.log('Register failed. Please check your credentials.');
    }
  }
}