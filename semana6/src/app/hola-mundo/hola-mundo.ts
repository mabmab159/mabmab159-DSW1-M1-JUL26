import { ChangeDetectorRef, Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { PokemonRespuesta } from '../interfaces/pokemon-respuesta';
import { firstValueFrom } from 'rxjs';
import { UsuarioLoginResponse } from '../interfaces/usuario-login-response';
import { FormControl, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { UsuarioLogin } from '../interfaces/usuario-login';

@Component({
  selector: 'app-hola-mundo',
  imports: [ReactiveFormsModule, FormsModule],
  templateUrl: './hola-mundo.html',
  styleUrl: './hola-mundo.css',
})
export class HolaMundo {
  ditto?: PokemonRespuesta;
  pokemones: PokemonRespuesta[] = [];
  usuarioLoginResponse?: UsuarioLoginResponse;
  usuarioLogin: any = new FormControl();
  passLogin: any = new FormControl();
  usuarioLoginRequest: UsuarioLogin = {} as UsuarioLogin;

  constructor(
    private readonly http: HttpClient,
    private readonly changeDetector: ChangeDetectorRef, //?Evita gestion del ciclo de vida | Detecta los cambios y renderiza
  ) {
    /*this.lecturaPokemon();
    this.lecturaPokemon2();
    this.lecturaPrimeros150();
    this.getBackend();
    this.login();*/
  }

  private lecturaPokemon(): void {
    this.http
      .get('https://pokeapi.co/api/v2/pokemon/ditto')
      .subscribe((response) => console.log(response));
  }

  private lecturaPokemon2(): void {
    this.http
      .get<PokemonRespuesta>('https://pokeapi.co/api/v2/pokemon/ditto')
      .subscribe((response) => {
        this.ditto = response;
        this.changeDetector.markForCheck();
      });
  }

  private async lecturaPrimeros150(): Promise<void> {
    for (let i: number = 1; i <= 150; i++) {
      const response = await firstValueFrom(
        this.http.get<PokemonRespuesta>(`https://pokeapi.co/api/v2/pokemon/${i}`),
      );
      this.pokemones.push(response);
    }
    this.changeDetector.markForCheck();
  }

  private getBackend(): void {
    this.http.get('http://localhost:9090/usuarios').subscribe((response) => console.log(response));
  }

  public login(): void {
    this.changeDetector.markForCheck();
    console.log(this.usuarioLoginRequest.usuario);
    console.log(this.usuarioLoginRequest.password);
    this.changeDetector.markForCheck();
    this.http
      .post<UsuarioLoginResponse>('http://localhost:9090/usuarios/login', {
        //usuario: this.usuarioLogin.value,
        //password: this.passLogin.value,
        usuario: this.usuarioLoginRequest.usuario,
        password: this.usuarioLoginRequest.password,
      })
      .subscribe((response) => {
        localStorage.setItem('token', response.token);
        this.obtenerDatosConToken();
      });
  }

  public obtenerDatosConToken(): void {
    this.http
      .get('http://localhost:9090/usuarios/unprotected', {
        headers: {
          Authorization: `${localStorage.getItem('token')}`,
        },
      })
      .subscribe((response) => console.log(response));
  }
}
