ts-
import { NgFor, NgIf } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { UserdataService } from '../../userdata.service';

@Component({
  selector: 'app-eventlist',
  standalone: true,
  imports: [NgIf,NgFor],
  templateUrl: './eventlist.component.html',
  styleUrl: './eventlist.component.css'
})
export class EventlistComponent implements OnInit{
  title = 'ems-client';
  events: any[] = [];
  organizer: any[] = [];

  constructor(private http: HttpClient , private userdataservice: UserdataService) { }

  ngOnInit(): void {
    this.fetchEvents();
  }


  fetchEvents(): void {
    this.userdataservice.getEvents()
      .subscribe(
        (response : any ) => { // change any here !!
          this.events = response.allEvents; 
          console.log('Events fetched successfully:', this.events);
        },
        error => console.error('Error fetching events: ', error)
      );
  }
  }
  htnl------------------
  <div *ngIf="events && events.length > 0" id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
  <ol class="carousel-indicators">
    <li *ngFor="let event of events; let i = index" data-target="#carouselExampleIndicators" [attr.data-slide-to]="i" [class.active]="i === 0"></li>
  </ol>
  <div class="carousel-inner">
    <div class="col-md-4 carousel-item" *ngFor="let event of events; let i = index" [class.active]="i === 0">
      <div class="card mb-4 card-hover  ">
        <div class="row g-0">
           
           <a class="col-lg-8 col-md-12 col-12 bg-cover img-left-rounded" style="background-image: url(https://media.istockphoto.com/id/1308964737/photo/business-professionals-applauding-at-a-seminar.jpg?s=1024x1024&w=is&k=20&c=rYvGtD2ObnDHrlwj-D4xa-UDppemHJWjXkbrHiU1IrI=);">
           <img src="https://media.istockphoto.com/id/1308964737/photo/business-professionals-applauding-at-a-seminar.jpg?s=1024x1024&w=is&k=20&c=rYvGtD2ObnDHrlwj-D4xa-UDppemHJWjXkbrHiU1IrI=" class="img-fluid d-lg-none invisible" alt=""></a>
           <div class="col-lg-4 col-md-12 col-12">
              
              <div class="card-body">
                 <a class="badge bg-warning mb-3">{{ event.eventCategory }}</a>
                 <h1 class="mb-4"> 
                  {{ event.eventName }}
                 </h1>
                 <h5>{{ event.description }}
                 </h5>
                 <div class="row align-items-center g-0 mt-7">
                    <div class="col lh-1 ">
                       <h5 class="mb-1">Chief Guest: {{ event.chiefGuest }}</h5>
                       <h5 class="fs-6 mb-0">Event Date: {{ event.eventDate }}</h5>
                    </div>

                 </div>
              </div>
           </div>
          </div>
        </div>
        </div>
  </div>
  <a class="carousel-control-prev"  role="button" data-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="carousel-control-next" role="button" data-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
<div *ngIf="!events || events.length === 0">
  No events found.
</div>
css------------------------------------------------------
.card {
    border: 1px solid #9cc5ee; 
    border-radius: 5px; 
    margin-bottom: 20px; 
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); 
    /* background-color: rgb(236, 147, 29); */
      /* fallback for old browsers */
  background: #fccb90;
  
  /* Chrome 10-25, Safari 5.1-6 */
  background: -webkit-linear-gradient(to right, #ee7724, #d8363a, #dd3675, #b44593);
  
  /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
  background: linear-gradient(to right, #ee7724, #d8363a, #dd3675, #b44593);
  }
