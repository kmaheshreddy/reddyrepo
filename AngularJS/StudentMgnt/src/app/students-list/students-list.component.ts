import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { StudentMgntServiceService } from '../student-mgnt-service.service';

@Component({
  selector: 'app-students-list',
  templateUrl: './students-list.component.html',
  styleUrls: ['./students-list.component.css']
})
export class StudentsListComponent implements OnInit {
  public users:User[];
  constructor(private service:StudentMgntServiceService) { }

  ngOnInit(): void {
    this.users=this.service.getData();
  }

}
