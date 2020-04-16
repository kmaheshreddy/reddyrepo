import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EmpComponent } from './emp/emp.component';
import { AddempComponent } from './addemp/addemp.component';
import { EmpupdateComponent } from './empupdate/empupdate.component';
import { EmpdetailsComponent } from './empdetails/empdetails.component';


const routes: Routes = [ {path:"getAllData",component:EmpComponent},
                         {path:"register",component:AddempComponent},
                         {path:"update/:id",component:EmpupdateComponent},
                         {path:"fetch/:id",component:EmpdetailsComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
