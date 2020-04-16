import { Component, OnInit } from '@angular/core';
import { EmpserviceService } from '../empservice.service';
import { Emp } from '../emp';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-empupdate',
  templateUrl: './empupdate.component.html',
  styleUrls: ['./empupdate.component.css']
})
export class EmpupdateComponent implements OnInit{
  emp1: Emp;
  id:number;
  flag:boolean;
  constructor(private empService:EmpserviceService,private router:Router,private route:ActivatedRoute) { }
  
  ngOnInit(): void {
    this.emp1=new Emp();
    this.flag=false;
    this.id=this.route.snapshot.params['id'];
    this.empService.getEmp(this.id).subscribe(
      data =>{
        this.emp1=data;
      });
  }
  updateEmp(){  
    this.empService.updateEmp(this.id,this.emp1)
      .subscribe(  
        data => {  
          console.log(data);
          this.emp1=new Emp();
          this.gotEmpList();
        });           
  } 
  onSubmit(){
    this.flag=true;
    this.updateEmp();
  }
  gotEmpList(){
     this.router.navigate(['/getAllData']);
  }

}
