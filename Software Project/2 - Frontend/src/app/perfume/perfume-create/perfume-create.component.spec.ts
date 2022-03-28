import {ComponentFixture, TestBed} from '@angular/core/testing';

import {PerfumeCreateComponent} from './perfume-create.component';

describe('PerfumeCreateComponent', () => {
  let component: PerfumeCreateComponent;
  let fixture: ComponentFixture<PerfumeCreateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [PerfumeCreateComponent]
    })
      .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PerfumeCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
