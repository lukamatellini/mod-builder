# QA Test Plan: Naval Architect

Generated: 2026-01-11T09:09:20.588Z
Minecraft Version: 1.21.1
Mod ID: navalarchitect

## Audit Summary

| Metric | Count |
|--------|-------|
| Total Checks | 22 |
| Passed | 15 |
| Failed | 1 |
| Warnings | 3 |
| Skipped | 3 |
| **Overall** | **FAILED** |

## Test Setup

1. Install Fabric Loader for Minecraft 1.21.1
2. Install Fabric API
3. Place `navalarchitect.jar` in mods folder
4. Launch Minecraft
5. Create new creative world or use existing test world

## Items Checklist

| Item | Get Command | Texture | Recipe | Functionality |
|------|-------------|---------|--------|---------------|
| Pilot Seat | `/give @p navalarchitect:pilot_seat` | ☐ | ☐ | ☐ |

### Item Tests

#### Pilot Seat

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Pilot Seat"

## Blocks Checklist

| Block | Get Command | Texture | Place | Break |
|-------|-------------|---------|-------|-------|
| Ship Core | `/give @p navalarchitect:ship_core` | ☐ | ☐ | ☐ |

## Notes

- Test in both creative and survival modes
- Check for console errors/warnings
- Verify no crashes on world load/unload
- Test multiplayer compatibility if applicable
