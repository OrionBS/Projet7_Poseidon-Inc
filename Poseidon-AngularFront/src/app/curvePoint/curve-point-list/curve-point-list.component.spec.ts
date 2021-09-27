import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CurvePointListComponent } from './curve-point-list.component';

describe('CurvePointListComponent', () => {
  let component: CurvePointListComponent;
  let fixture: ComponentFixture<CurvePointListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CurvePointListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CurvePointListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
