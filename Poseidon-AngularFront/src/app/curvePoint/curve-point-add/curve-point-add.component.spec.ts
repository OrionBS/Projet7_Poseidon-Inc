import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CurvePointAddComponent } from './curve-point-add.component';

describe('CurvePointAddComponent', () => {
  let component: CurvePointAddComponent;
  let fixture: ComponentFixture<CurvePointAddComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CurvePointAddComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CurvePointAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
