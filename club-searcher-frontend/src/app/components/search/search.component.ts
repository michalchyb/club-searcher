import { Component, OnInit } from '@angular/core';
import { SearcherService } from 'src/app/services/searcher.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.scss']
})
export class SearchComponent implements OnInit {

  clubname: String;
  link: any;

  constructor(private searchService: SearcherService) { }

  ngOnInit() {
  }
  searchClub() {
    this.searchService.getLink(this.clubname)
      .subscribe(
        data => {
          this.link = data;
        },
        error => {
          console.log(error);
        }
      )
  }
}
