import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {HeaderComponent} from './component/header/header.component';
import {NavComponent} from './component/nav/nav.component';
import {MainComponent} from './component/main/main.component';
import {FooterComponent} from './component/footer/footer.component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, HeaderComponent, NavComponent, MainComponent, FooterComponent],
  templateUrl: './app.component.html',
  standalone: true,
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'AUI-PROJ-ANGULAR';
}
