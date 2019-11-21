import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CheckPointComponent } from './check-point.component';

describe('CheckPointComponent', () => {
  let component: CheckPointComponent;
  let fixture: ComponentFixture<CheckPointComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CheckPointComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CheckPointComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
