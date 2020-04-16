import { Component, OnInit } from '@angular/core';
import { Emp } from '../emp';
import { Router } from '@angular/router';
import { EmpserviceService } from '../empservice.service';

@Component({
  selector: 'app-addemp',
  templateUrl: './addemp.component.html',
  styleUrls: ['./addemp.component.css']
})
export class AddempComponent implements OnInit{
  emp: Emp;
  flag:boolean;
  constructor(private router: Router, private userService: EmpserviceService) {
         
  }
  ngOnInit(): void {
       this.emp=new Emp();
       this.flag=false;
  }
  
  createEmp(): void {
    this.userService.createUser(this.emp)
        .subscribe( data => {
          this.emp=new Emp();
          alert("User created successfully.");
        });

  };
  onSubmit(){
  this.createEmp();
  this.flag=true;
  }
}
