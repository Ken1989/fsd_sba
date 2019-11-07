import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { AlertService } from 'src/app/service/alert.service';
import { AuthenticationService } from 'src/app/service/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;

  loading = false;
  submitted = false;
  returnUrl: string;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private alertService: AlertService,
    private authenticationService: AuthenticationService,
  ) {
            // redirect to home if already logged in
            if (this.authenticationService.currentUserValue) {
              this.router.navigate(['/']);
          }
  }

  ngOnInit() {
    this.loginForm = new FormGroup({
      Username: new FormControl('', [Validators.required]),
      password: new FormControl('', [Validators.required, Validators.minLength(6)]),
    });
    // get return url from route parameters or default to '/'
    this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
  }

  hasError = (controlName: string, errorName: string) => {
    return this.loginForm.controls[controlName].hasError(errorName);
  }

  login(loginFormValue) {
    if (this.loginForm.valid) {
      this.submitted = true;

      this.loading = true;
      this.authenticationService.login(loginFormValue.email, loginFormValue.password)
          .subscribe(
            data => {
              this.router.navigate([this.returnUrl]);
            },
              error => {
                  this.alertService.error('Username or Password invalid');
                  this.loading = false;
              });
    }

  }

}
