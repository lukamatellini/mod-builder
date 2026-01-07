# QA Test Plan: Yokai Uprising

Generated: 2026-01-07T02:29:34.611Z
Minecraft Version: 1.21.1
Mod ID: yokaiuprising

## Audit Summary

| Metric | Count |
|--------|-------|
| Total Checks | 65 |
| Passed | 53 |
| Failed | 8 |
| Warnings | 3 |
| Skipped | 1 |
| **Overall** | **FAILED** |

## Test Setup

1. Install Fabric Loader for Minecraft 1.21.1
2. Install Fabric API
3. Place `yokaiuprising.jar` in mods folder
4. Launch Minecraft
5. Create new creative world or use existing test world

## Items Checklist

| Item | Get Command | Texture | Recipe | Functionality |
|------|-------------|---------|--------|---------------|
| Mutated Flesh | `/give @p yokaiuprising:mutated_flesh` | ☐ | ☐ | ☐ |
| Cooked Mutated Flesh | `/give @p yokaiuprising:cooked_mutated_flesh` | ☐ | ☐ | ☐ |
| Worm Meat | `/give @p yokaiuprising:worm_meat` | ☐ | ☐ | ☐ |
| Cooked Worm Meat | `/give @p yokaiuprising:cooked_worm_meat` | ☐ | ☐ | ☐ |
| Sumo Belt | `/give @p yokaiuprising:sumo_belt` | ☐ | ☐ | ☐ |
| Raw Porkchop | `/give @p yokaiuprising:raw_porkchop` | ☐ | ☐ | ☐ |
| 1 Leather | `/give @p yokaiuprising:1_leather` | ☐ | ☐ | ☐ |
| Itself | `/give @p yokaiuprising:itself` | ☐ | ☐ | ☐ |

### Item Tests

#### Mutated Flesh

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Mutated Flesh"
- [ ] Crafting recipe works

#### Cooked Mutated Flesh

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Cooked Mutated Flesh"
- [ ] Crafting recipe works

#### Worm Meat

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Worm Meat"
- [ ] Crafting recipe works

#### Cooked Worm Meat

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Cooked Worm Meat"
- [ ] Crafting recipe works

#### Sumo Belt

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Sumo Belt"
- [ ] Crafting recipe works

#### Raw Porkchop

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Raw Porkchop"

#### 1 Leather

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "1 Leather"

#### Itself

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Itself"

## Blocks Checklist

| Block | Get Command | Texture | Place | Break |
|-------|-------------|---------|-------|-------|
| Dohyo Ring Block | `/give @p yokaiuprising:doho_ring_block` | ☐ | ☐ | ☐ |

## Mobs Checklist

| Mob | Summon Command | Spawns | AI | Drops |
|-----|----------------|--------|-----|-------|
| Mutated Zombie | `/summon yokaiuprising:mutated_zombie` | ☐ | ☐ | ☐ |
| Cave Worm | `/summon yokaiuprising:cave_worm` | ☐ | ☐ | ☐ |
| Sumo Wrestler | `/summon yokaiuprising:sumo_wrestler` | ☐ | ☐ | ☐ |

### Mob Tests

#### Mutated Zombie

- [ ] Spawns with `/summon yokaiuprising:mutated_zombie`
- [ ] Has correct health: 40
- [ ] Deals expected damage: 8
- [ ] AI behavior works (hostile)
- [ ] Drops loot on death:
  - [ ] minecraft:rotten_flesh (100% chance)
  - [ ] yokaiuprising:mutated_flesh (100% chance)

#### Cave Worm

- [ ] Spawns with `/summon yokaiuprising:cave_worm`
- [ ] Has correct health: 25
- [ ] Deals expected damage: 5
- [ ] AI behavior works (hostile)
- [ ] Drops loot on death:
  - [ ] minecraft:string (100% chance)
  - [ ] yokaiuprising:worm_meat (100% chance)

#### Sumo Wrestler

- [ ] Spawns with `/summon yokaiuprising:sumo_wrestler`
- [ ] Has correct health: 70
- [ ] Deals expected damage: 12
- [ ] AI behavior works (neutral)
- [ ] Drops loot on death:
  - [ ] yokaiuprising:raw_porkchop (100% chance)
  - [ ] yokaiuprising:1_leather (100% chance)
  - [ ] yokaiuprising:sumo_belt (100% chance)

## Structures Checklist

### Sumo Dohyo
- [ ] Structure generates in world
- [ ] Use `/locate structure yokaiuprising:sumo_doho` to find
- [ ] Contains expected features

## Notes

- Test in both creative and survival modes
- Check for console errors/warnings
- Verify no crashes on world load/unload
- Test multiplayer compatibility if applicable
