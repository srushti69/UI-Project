import {Injectable} from '@angular/core';
import {Http, Headers, RequestOptions} from '@angular/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';
import 'rxjs/add/observable/throw';

@Injectable()
export class UserService {
    constructor(private http: Http) {
    }

    getUsers(): Observable<any[]> {
        return this.http.get('https://learn.egen.io/courses/movielist.json')
            .map(response => response.json())
            .catch(error => Observable.throw(error.statusText));
    }

    getUserById(id: string): Observable<any[]> {
        return this.http.get(`https://learn.egen.io/courses/movielist.json`)
            .map(response => response.json())
            .catch(error => Observable.throw(error.statusText));
    }

    createUser(user: any): Observable<any[]> {
        let headers = new Headers({'Content-Type': 'application/json'});
        let options = new RequestOptions({headers: headers});
        return this.http.post('https://learn.egen.io/courses/movielist.json', user, options)
            .map(response => response.json())
            .catch(error => Observable.throw(error.statusText));
    }

    updateUser(id: string, user: any): Observable<any[]> {
        let headers = new Headers({'Content-Type': 'application/json'});
        let options = new RequestOptions({headers: headers});
        return this.http.post(`https://learn.egen.io/courses/movielist.json`, user, options)
            .map(response => response.json())
            .catch(error => Observable.throw(error.statusText));
    }
}

