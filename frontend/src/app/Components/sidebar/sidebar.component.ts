import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, NavigationEnd } from '@angular/router';
import { filter } from 'rxjs/operators';
import { StaffService } from '../staff/staff.service';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent {
  constructor(private router: Router, private activatedRoute: ActivatedRoute, private authService: StaffService) { }
  navigateToComponent(route: string): void {
    this.router.navigate([route]);
  }  
  navLinks = [
    { path: '/dashboard', label: 'Dashboard', icon: 'fas fa-home' },
    { path: '/appointments', label: 'Appointments', icon: 'far fa-calendar' },
    { path: '/departments', label: 'Departments', icon: 'fas fa-hospital' },
    { path: '/logout', label: 'Logout', icon: 'fas fa-sign-out-alt' },
    { path: '/prescription', label: 'Prescription', icon: 'fas fa-file-prescription' },
    { path: '/doctors', label: 'Doctors', icon: 'fas fa-user-md' },
  ];
  
  showSidebar: boolean = true;
  showDepartmentsLink: boolean = true;
  showDoctorsLink: boolean = true;

  ngOnInit(): void {
    this.router.events.pipe(
      filter(event => event instanceof NavigationEnd)
    ).subscribe(() => {
      const isLoginPage = this.activatedRoute.firstChild?.snapshot.routeConfig?.path === 'login';
      const isRegisterPage = this.activatedRoute.firstChild?.snapshot.routeConfig?.path === 'register';
      this.showSidebar = !(isLoginPage || isRegisterPage);
    });
    this.authService.isUserNurse().subscribe((result: boolean) => {
      this.showDepartmentsLink = result;
      this.showDoctorsLink = result;
    });
  }
}
