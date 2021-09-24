import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CurvePointUpdateComponent } from './curve-point-update.component';

describe('CurvePointUpdateComponent', () => {
  let component: CurvePointUpdateComponent;
  let fixture: ComponentFixture<CurvePointUpdateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CurvePointUpdateComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CurvePointUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
