import { Injectable } from '@angular/core';
import { Emp } from './emp';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmpserviceService {
  constructor(private http:HttpClient) {}

  private userUrl = 'http://localhost:4141/SpringWithRestFull-2-EmployeeMgnt/api';
   //private userUrl = '/api';

  public getUsers():Observable<any>{
    return this.http.get(`${this.userUrl}`);
  }

  public deleteUser(id:number): Observable<any>{
    return this.http.delete(`${this.userUrl}/${id}`);
  }

  public createUser(emp:Emp): Observable<Object>{
    return this.http.post(this.userUrl, emp);
  }
  getEmp(id: number): Observable<any> {  
    return this.http.get(`${this.userUrl}/${id}`);  
  }  
  
  updateEmp(id:number,value:any): Observable<Object> {  
    return this.http.post(`${this.userUrl}/${id}`,value);  
  }  
  authenticate(username, password) {
    console.log(username);
    console.log(password);
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ':' + password) });
    return this.http.get<Emp>('http://localhost:8080/employees/validateLogin', { headers }).pipe(
      map(
        userData => {
          sessionStorage.setItem('username', username);
          let authString = 'Basic ' + btoa(username + ':' + password);
          sessionStorage.setItem('basicauth', authString);
          return userData;
        }
      )

    );
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem('username')
    console.log(!(user === null))
    return !(user === null)
  }

  logOut() {
    sessionStorage.removeItem('username')
  }
}
