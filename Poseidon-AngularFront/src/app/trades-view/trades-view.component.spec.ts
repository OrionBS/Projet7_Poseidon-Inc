import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TradesViewComponent } from './trades-view.component';

describe('TradesViewComponent', () => {
  let component: TradesViewComponent;
  let fixture: ComponentFixture<TradesViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TradesViewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TradesViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
