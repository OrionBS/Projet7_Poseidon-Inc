import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CurvePointsViewComponent } from './curve-points-view.component';

describe('CurvePointsViewComponent', () => {
  let component: CurvePointsViewComponent;
  let fixture: ComponentFixture<CurvePointsViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CurvePointsViewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CurvePointsViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
