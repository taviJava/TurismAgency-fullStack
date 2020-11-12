import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.css']
})
export class TestComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
    $(document).on('ready',function(): void{
      $('.reserved input').prop('checked', true);
      // tslint:disable-next-line:typedef
      $('label').on('click', function(): void{
        if (!$(this).hasClass('reserved')){
          if ($(this).find('input').is(':checked')){
            $(this).addClass('selected');
          }else{
            console.log('selected');
            $(this).removeClass('selected');
          }
        }
        else{
          alert('Already booked');
        }
      });
    });
  }

}
