import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BidsViewComponent } from './bids-view.component';

describe('BidsViewComponent', () => {
  let component: BidsViewComponent;
  let fixture: ComponentFixture<BidsViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BidsViewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BidsViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
