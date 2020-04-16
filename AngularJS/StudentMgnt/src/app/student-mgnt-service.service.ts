import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class StudentMgntServiceService {
  constructor(){

  }
  getData(){
    return [{"id":1,"name":"mahesh","age":25},
            {"id":2,"name":"masthan","age":25},
            {"id":3,"name":"rajesh","age":25}];
  }
}
