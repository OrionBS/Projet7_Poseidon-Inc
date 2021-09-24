import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BidsDialogComponent } from './bids-dialog.component';

describe('BidsDialogComponent', () => {
  let component: BidsDialogComponent;
  let fixture: ComponentFixture<BidsDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BidsDialogComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BidsDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
