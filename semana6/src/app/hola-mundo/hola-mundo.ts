import { ChangeDetectorRef, Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { PokemonRespuesta } from '../interfaces/pokemon-respuesta';
import { firstValueFrom } from 'rxjs';

@Component({
  selector: 'app-hola-mundo',
  imports: [],
  templateUrl: './hola-mundo.html',
  styleUrl: './hola-mundo.css',
})
export class HolaMundo {
  ditto?: PokemonRespuesta;
  pokemones: PokemonRespuesta[] = [];

  constructor(
    private readonly http: HttpClient,
    private readonly changeDetector: ChangeDetectorRef, //?Evita gestion del ciclo de vida | Detecta los cambios y renderiza
  ) {
    this.lecturaPokemon();
    this.lecturaPokemon2();
    this.lecturaPrimeros150();
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
        this.http.get<PokemonRespuesta>(`https://pokeapi.co/api/v2/pokemon/${i}`)
      );
      this.pokemones.push(response);
    }
    this.changeDetector.markForCheck();
  }
}
