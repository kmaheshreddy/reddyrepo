import { Component, OnInit } from '@angular/core';
import { Emp } from '../emp';
import { EmpserviceService } from '../empservice.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-empdetails',
  templateUrl: './empdetails.component.html',
  styleUrls: ['./empdetails.component.css']
})
export class EmpdetailsComponent implements OnInit {
  emp: Emp;
  id:number;
  constructor(private empService:EmpserviceService,private router:Router,private route:ActivatedRoute) { }
  
  ngOnInit(): void {
  }
  submit(){
    this.empService.getEmp(this.id).subscribe(
      data =>{
        this.emp=data;
      },error=>alert(error));
  }
}
