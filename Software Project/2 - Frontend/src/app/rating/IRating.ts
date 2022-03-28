import {IPerfume} from "../perfume/IPerfume";

export interface IRating {
  user: string,
  perfumeResource: IPerfume,
  value_scent: number,
  value_durability: number,
  value_sillage: number,
  value_vial: number,
  value_charge: number
}
