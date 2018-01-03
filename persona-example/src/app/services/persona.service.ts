import {Injectable} from "@angular/core";
import {Http, Headers, Response} from '@angular/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/Rx'

import {Persona} from '../models/persona';

@Injectable()
export class PersonaService {
  
  URL: string;
  
  constructor (private http: Http) {
      //this.URL = 'http://192.168.1.42:8015/api';
      this.URL = 'https://localhost:8011/api';
  }

  getList() : Observable<Array<Persona>>{
    return this.http.get(this.URL +'/list/departments')
      .map(this.extractDataArray)
      .catch(this.handleError);
  }

  getPersonaByCode(code: string) : Observable<Persona>{
    return this.http.get(this.URL +'/find/' + code)
      .map(this.extractDataArray)
      .catch(this.handleError);
  }

  private extractDataObject(res: Response) {
    let body = res.json();
    return body || { };
  }
  
  private extractDataArray(res: Response) {
    let body = res.json();
    return body || [ ];
  }
  
  private handleError(error: Response) {
        console.error(error);
        return Observable.throw(error.json().error || 'Server Error');
  }
}
