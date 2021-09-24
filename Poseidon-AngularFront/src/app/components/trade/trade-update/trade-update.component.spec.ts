import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TradeUpdateComponent } from './trade-update.component';

describe('TradeUpdateComponent', () => {
  let component: TradeUpdateComponent;
  let fixture: ComponentFixture<TradeUpdateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TradeUpdateComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TradeUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
