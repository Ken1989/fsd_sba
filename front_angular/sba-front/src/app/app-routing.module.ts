import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './layout/home/home.component';
import { LoginComponent } from './layout/login/login.component';
import { CourseComponent } from './view/course/course.component';
import { CourseListComponent } from './view/course-list/course-list.component';
import { MentorComponent } from './view/mentor/mentor.component';
import { MentorListComponent } from './view/mentor-list/mentor-list.component';
import { UserListComponent } from './view/user-list/user-list.component';
import { UserComponent } from './view/user/user.component';


const routes: Routes = [
  {
    path: 'home',
    component: HomeComponent,
    // canActivate : [AuthGard]
    children: [
      {
        path: "",
        redirectTo: 'course-list',
        pathMatch:  ''
      },
      {
        path: 'course',
        component: CourseComponent
      },
      {
        path: 'course-list',
        component: CourseListComponent
      },
      {
        path: 'mentor',
        component: MentorComponent
      },
      {
        path: 'mentor-list',
        component: MentorListComponent
      },
      {
        path: 'user-list',
        component: UserListComponent
      },
      {
        path: 'user',
        component: UserComponent
      }
    ]
  },
  {
    path: 'login',
    component: LoginComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
