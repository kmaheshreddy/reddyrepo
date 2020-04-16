import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { StudentMgntServiceService } from '../student-mgnt-service.service';

@Component({
  selector: 'app-student-details',
  templateUrl: './student-details.component.html',
  styleUrls: ['./student-details.component.css']
})
export class StudentDetailsComponent implements OnInit {

  public users:User[];
  constructor(private service:StudentMgntServiceService) { }

  ngOnInit(): void {
    this.users=this.service.getData();
  }

}
