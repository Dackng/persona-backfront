import {Component, OnInit} from '@angular/core';
import {PersonaService} from '../../services/persona.service';
import {Persona} from '../../models/persona';

@Component({
  selector: 'dashboard',
  styleUrls: ['./dashboard.scss'],
  templateUrl: './dashboard.html',
  providers: [PersonaService]
})
export class Dashboard implements OnInit{
  personList: Array<Persona> =[];
  errorMessage: string = "";
  constructor(private _personaService: PersonaService) {
    
  }

  ngOnInit(){
        this._personaService.getList().subscribe( (list : Array<Persona> ) => {
                this.personList = list;
        }, error => this.errorMessage = <any> error);
  }
}
