import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

declare var html2canvas: any;
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';
  showDropDown = false;
  backgroundImagePath: string;

  smileyImagePath: string;
  frownImagePath: string;
  display= 'none';
  showFeedbackText = false;
  feedback = '';

  constructor(private http: HttpClient) {
      this.smileyImagePath = './assets/smiley.png';
      this.frownImagePath = './assets/frown.png';
      this.backgroundImagePath = './assets/background.svg';
  }

  openModal(feedback: string) {
    this.display = 'block';
    this.feedback = feedback;
    if (feedback === 'sad') {
      this.showFeedbackText = true;
    }
  }

  onCloseHandled() {
    this.display = 'none';
    this.showFeedbackText = false;
    if (this.feedback === 'sad') {
      this.http.get('/save').subscribe(data => {
        console.log(data);
      });
    }
  }

  onCancelHandled() {
    this.display = 'none';
    this.showFeedbackText = false;
    if (this.feedback === 'sad') {
      this.http.get('/save').subscribe(data => {
        console.log(data);
      });
    }
  }

  onInclude() {
    html2canvas(document.getElementById('mainContent')).then(function(canvas) {
      const img: any = canvas.toDataURL('image/png');
      document.getElementById('box1').innerHTML = '<img width="75%;" src="' + img + '"/>';
    });
  }
}
