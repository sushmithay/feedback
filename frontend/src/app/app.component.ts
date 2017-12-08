import { Component , OnInit} from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormGroup, FormControl } from '@angular/forms';
import {RequestOptions, Headers, RequestMethod} from '@angular/http';

declare var html2canvas: any;

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'app';
  showDropDown = false;
  backgroundImagePath: string;

  smileyImagePath: string;
  frownImagePath: string;
  display= 'none';
  showFeedbackText = false;
  feedback = '';
  form: FormGroup;
  counter = 0;
  textAreaValue = 'hello there';

  constructor(private http: HttpClient) {
      this.smileyImagePath = './assets/smiley.png';
      this.frownImagePath = './assets/frown.png';
      this.backgroundImagePath = './assets/background.svg';
  }

  ngOnInit() {
      this.form = new FormGroup({
        include: new FormControl(false)
      });
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
    let feedback = {};
    if (this.feedback === 'sad') {
      feedback = {
        'feedbackType': 'bad',
        'feedbackText': this.textAreaValue
      };
    } else {
      feedback = {
        'feedbackType': 'good'
      };
    }
    const req = this.http.post('/feedbackapi/create/1', feedback);
    req.subscribe();
  }

  onCancelHandled() {
    this.display = 'none';
    this.showFeedbackText = false;
    const feedback = {
      'feedbackType': 'bad'
    };
    const req = this.http.post('/feedbackapi/create/1', feedback);
    req.subscribe();
  }

  onInclude() {
    if (this.form.controls['include'].value) {
      html2canvas(document.getElementById('mainContent')).then(function(canvas) {
        document.getElementById('box1').innerHTML = '';
        const img: any = canvas.toDataURL('image/png');
        document.getElementById('box1').innerHTML = '<img width="75%;" src="' + img + '"/>';
      });
    } else {
      document.getElementById('box1').innerHTML = '';
    }
  }

  doTextareaValueChange(ev) {
    try {
      this.textAreaValue = ev.target.value;
    } catch (e) {
      console.log('could not set textarea-value');
    }
  }
}
