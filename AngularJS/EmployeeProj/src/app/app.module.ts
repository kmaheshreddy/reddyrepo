import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { EmpserviceService } from './empservice.service';
import { AppRoutingModule } from './app-routing.module';
import { EmpdetailsComponent } from './empdetails/empdetails.component';
import { AddempComponent } from './addemp/addemp.component';
import { EmpComponent } from './emp/emp.component';
import { EmpupdateComponent } from './empupdate/empupdate.component';
import { LoginComponent } from './login/login.component';

const appRoutes:Routes=[]

@NgModule({
  declarations: [
    AppComponent,
    EmpdetailsComponent,
    AddempComponent,
    EmpComponent,
    EmpupdateComponent,
    LoginComponent
  ],
  imports: [
    AppRoutingModule,
    BrowserModule,
    HttpClientModule,
    FormsModule
  ],
  providers:[EmpserviceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
