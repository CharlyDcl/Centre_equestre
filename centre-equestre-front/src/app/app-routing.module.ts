import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { CoursComponentComponent } from './cours-component/cours-component.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponentComponent } from './home-component/home-component.component';
import { LoginComponentComponent } from './login-component/login-component.component';
import { SignUpComponentComponent } from './sign-up-component/sign-up-component.component';
import { UserComponentComponent } from './user-component/user-component.component';

const routes: Routes = [
  {path:'home',
  component: HomeComponentComponent},
  {path:'cours',
  component: CoursComponentComponent},
  {path:'user',
  component: UserComponentComponent},
  {path:'login',
  component: LoginComponentComponent},
  {path:'sign_up',
  component: SignUpComponentComponent},
  {path:'',
  component: HomeComponentComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
