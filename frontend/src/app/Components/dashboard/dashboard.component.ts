import { Component, ElementRef, ViewChild } from '@angular/core';

declare var Chart: any;

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent {
  @ViewChild('myChart') myChart!: ElementRef;

  chartData: number[] = [65, 59, 80, 81, 56, 55, 40];
  chartLabels: string[] = ['January', 'February', 'March', 'April', 'May', 'June', 'July'];

  totalPatients: number = 1200;
  totalDoctors: number = 150;
  appointmentsToday: number = 30;

  constructor() {}

  ngAfterViewInit(): void {
    if (this.myChart) {
      this.createChart();
    } else {
      console.error('myChart element is not available.');
    }
  }

  newsList: { title: string; description: string }[] = [
    {
      title: 'radical change in H-C',
      description: 'B.C. touts ‘radical change’ in health-care system as recruitment efforts continue'
    },
    {
      title: 'Urgent hospital condition',
      description: '26 per cent of Ontario hospital buildings are in poor condition and five buildings need to be replaced entirely'
    }
  ];

  createChart(): void {
    const ctx = this.myChart.nativeElement.getContext('2d');
    new Chart(ctx, {
      type: 'bar',
      data: {
        labels: this.chartLabels,
        datasets: [
          {
            label: 'Monthly Activity',
            data: this.chartData,
            backgroundColor: 'rgba(75,192,192,0.2)'
          }
        ]
      },
      options: {
        responsive: true
      }
    });
  }
}
