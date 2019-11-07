import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { AlertService } from 'src/app/service/alert.service';
import {MatSnackBar} from '@angular/material/snack-bar';

@Component({
  selector: 'app-alert',
  templateUrl: './alert.component.html',
  styleUrls: ['./alert.component.scss']
})
export class AlertComponent implements OnInit {

  private subscription: Subscription;
    message: any;

  constructor(private alertService: AlertService, private snackBar: MatSnackBar) { }

  ngOnInit() {
    this.subscription = this.alertService.getAlert()
            .subscribe(message => {
                switch (message && message.type) {
                    case 'success':
                        this.snackBar.open(message.text, 'close', {
                          duration: 2000,
                        });
                        break;
                    case 'warn':
                          this.snackBar.open(message.text, 'close', {
                            duration: 2000,
                          });
                          break;
                    case 'error':
                        this.snackBar.open(message.text, 'close', {
                          duration: 2000,
                        });
                        break;
                }

                this.message = message;
            });
  }

  ngOnDestroy() {
    this.subscription.unsubscribe();
}

}
