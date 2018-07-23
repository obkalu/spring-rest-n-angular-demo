import { Injectable } from '@angular/core';
import {Http, Response} from '@angular/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/map';

@Injectable()
export class CustomerService {

  // Dependency injection
  constructor(private http: Http) { }

  getCustomers(): Observable<any> {
    return this.http.get('http://localhost:8080/customers')
      .map((response: Response) => response.json());
  }

}
