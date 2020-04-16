import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EmpserviceService } from '../empservice.service';
import { Emp } from '../emp';
import { FormGroup, FormControl } from '@angular/forms';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-emp',
  templateUrl: './emp.component.html',
  styleUrls: ['./emp.component.css']
})
export class EmpComponent implements OnInit {
  emps:Observable<Emp[]>;
  searchText :string;
  empList:any;
  constructor(private router: Router, private userService: EmpserviceService) {

  }
  ngOnInit() {
    this.userService.getUsers()
    .subscribe(data =>{
        this.emps=data;
    });
  };
   
  deleteUser(id:number): void {
    this.userService.deleteUser(id)
    .subscribe( data => {
    },error=>console.error());
  }
  updateEmp(id:number){
    this.router.navigate(['update',id]);
  }


}
